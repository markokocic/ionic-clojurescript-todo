(ns iotodo.subs
  (:require
   [refx.alpha :as rf]))

(rf/reg-sub
 :todos/all
 (fn [db _]
   (:todos db)))
