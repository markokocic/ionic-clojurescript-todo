(ns iotodo.events
  (:require
   [re-frame.core :as rf]
   [iotodo.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))
   

(rf/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(rf/reg-event-db
 :todos/add
 (fn [db [_ val]]
   (if (= "" val)
     db
     (update-in
      db [:todos]
      #(conj (:todos db) {:text val :key (js/Date.now) :checked false})))))

(rf/reg-event-db
 :todos/check
 (fn [db [_ val]]
   (update-in
    db [:todos]
    #(map (fn [item]
            (if (= val (:key item))
              (update-in item [:checked] not)
              item))
          (db :todos)))))

(rf/reg-event-db
 :todos/delete
 (fn [db [_ val]]
   (update-in
    db [:todos]
    (fn [] (remove #(= (:key %) val) (:todos db))))))


