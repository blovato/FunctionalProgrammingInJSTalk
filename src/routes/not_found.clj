(ns routes.not_found
  (:require [routes.common :refer [resource-root]]
            [ring.util.response :refer [file-response]]))

(defn file-name [] "not-found.html")
(defn handler [request]
  (file-response (file-name) (resource-root)))
