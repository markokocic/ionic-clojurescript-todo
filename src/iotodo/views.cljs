(ns iotodo.views
  (:require
   [reagent.core :as r]
   [re-frame.core :as rf]
   [ion.core :as ion]
   ["ionicons/icons" :as icons]
   [iotodo.subs :as subs]))

(defn- input-container []
  (let [value (r/atom "")]
    (fn []
      [ion/item
       [ion/textarea {:slot :start :placeholder "Todo ..."
                      :auto-grow true :autofocus true
                      :inputmode "text"
                      :value @value
                      :on-ion-change #(reset! value (.. % -detail -value))}]
       [ion/button {:slot "end" :icon-only true
                    :on-click (fn []
                                (rf/dispatch [:todos/add @value])
                                (reset! value ""))}
        [ion/icon {:icon icons/add}]]])))

(defn- todo-item [{:keys [key text checked]}]
  [ion/item {:key key}
   [ion/checkbox {:slot "start" :checked checked
                  :on-ion-change #(rf/dispatch [:todos/check key])}]
   [ion/text
    {:style {:text-decoration (if checked :line-through :none)}} text]
   
   [ion/button {:slot "end" :icon-only true
                :on-click #(rf/dispatch [:todos/delete key])}
    [ion/icon {:icon icons/trash}]]])


(defn- todos []
  (let [todos (rf/subscribe [:todos/all])]
    [ion/list
     [input-container]
     (for [todo @todos]
       [todo-item todo])]))

(defn- todo-screen []
  [ion/app
   [ion/header
    [ion/toolbar
     [ion/title "Todo List"]]]
   [ion/content {:class "IosPadding"}
    [ion/grid
     [ion/row
      [todos]]]]])

(defn main-panel []
  [todo-screen])     
