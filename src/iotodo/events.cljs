(ns iotodo.events
  (:require
   [refx.alpha :as rf]
   [iotodo.db :as db]))


(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-db
 :todos/add
 (fn [db [_ val]]
   (if (= "" val)
     db
     (update-in
      db [:todos]
      #(conj (:todos db) {:text val :id (js/Date.now) :checked false})))))

(rf/reg-event-db
 :todos/check
 (fn [db [_ val]]
   (update-in
    db [:todos]
    #(map (fn [item]
            (if (= val (:id item))
              (update-in item [:checked] not)
              item))
          (db :todos)))))

(rf/reg-event-db
 :todos/delete
 (fn [db [_ val]]
   (update-in
    db [:todos]
    (fn [] (remove #(= (:id %) val) (:todos db))))))


