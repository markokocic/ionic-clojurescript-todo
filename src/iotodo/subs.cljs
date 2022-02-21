(ns iotodo.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 :todos/all
 (fn [db _]
   (:todos db)))
