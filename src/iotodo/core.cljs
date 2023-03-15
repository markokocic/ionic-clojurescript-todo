(ns iotodo.core
  (:require
   [refx.alpha :as rf]
   ["react" :as react]
   ["react-dom" :as react-dom]
   ["react-dom/client" :refer [createRoot]]
   ["@ionic/react" :as i]
   [helix.core :refer [$]]
   [iotodo.subs :as subs]
   [iotodo.events :as events]
   [iotodo.views :as views]
   [iotodo.config :as config]))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defonce root (createRoot (js/document.getElementById "app")))

(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (.render root ($ views/main-panel)))

(defn ^:export init []
  (i/setupIonicReact)
  (rf/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
