(ns iotodo.views
  (:require
   ["@ionic/react" :as i]
   ["ionicons/icons" :as icons]
   [helix.core :refer [defnc $ <>]]
   [helix.hooks :refer [use-state]]
   [helix.dom :as d]
   [refx.alpha :as rf]))


(defnc input-container []
  (let [[value set-value!] (use-state "")]
    ($ i/IonItem
       ($ i/IonTextarea {:slot "start" :placeholder "Todo ..."
                         :autoGrow true :autofocus true
                         :inputmode "text"
                         :value value
                         :onIonChange #(set-value! (.. % -detail -value))})
       ($ i/IonButton {:slot "end" :iconOnly true
                       :onClick (fn []
                                  (rf/dispatch [:todos/add value])
                                  (set-value! ""))}
          ($ i/IonIcon {:icon icons/add})))))


(defnc todo-item [{:keys [id text checked]}]
  ($ i/IonItem
     ($ i/IonCheckbox
        {:slot "start" :checked checked
         :onIonChange #(rf/dispatch [:todos/check id])})
     ($ i/IonText
        {:style #js{:textDecoration (if checked "line-through" "none")}}
        text)
     ($ i/IonButton
        {:slot "end" :iconOnly true
         :onClick #(rf/dispatch [:todos/delete id])}
        ($ i/IonIcon {:icon icons/trash}))))

(defnc todos []
  (let [todos (rf/use-sub [:todos/all])]
    ($ i/IonList
       ($ input-container)
       (for [todo todos]
         ($ todo-item {:key (:id todo) :& todo})))))

(defnc todo-screen []
  ($ i/IonApp
     ($ i/IonHeader
        ($ i/IonToolbar
           ($ i/IonTitle "Todo List")))
     ($ i/IonContent {:class "ion-padding"}
        ($ i/IonGrid
           ($ i/IonRow
              ($ todos))))))

(defn main-panel []
  ($ todo-screen))
