(ns routes.index
  (:require [routes.common :refer [resource-root]]
            [ring.util.response :refer [file-response]]))

(defn path [] "/")
(defn file-name [] "index.html")
(defn handler [request]
  (file-response (file-name) (resource-root)))
