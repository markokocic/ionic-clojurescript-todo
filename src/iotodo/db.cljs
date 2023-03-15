(ns iotodo.db)

(def default-db
  {:name "re-frame"
   :todos
   (list
    {:text "Sample checked" :id 1 :checked true}
    {:text "Sample unchecked" :id 2 :checked false}
    {:text "Sample long text that will overflow at one point and be long more that one line that can or can not be so longs as it is possible" :id 3 :checked false})})
