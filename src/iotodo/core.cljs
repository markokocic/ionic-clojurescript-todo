(ns iotodo.core
  (:require
   [reagent.dom :as dom]
   [re-frame.core :as rf]
   [ion.core :as ion]
   [iotodo.events :as events]
   [iotodo.views :as views]
   [iotodo.config :as config]))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (dom/unmount-component-at-node root-el)
    (dom/render [views/main-panel] root-el)))

(defn init []
  (ion/setup-ionic-react)
  (rf/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
