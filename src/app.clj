(ns app
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.util.response :refer [file-response]]
            [routes.index]
            [routes.not_found]))
(use 'ring.adapter.jetty)

(defroutes app
  (GET (routes.index/path) [] routes.index/handler)
  (route/not-found routes.not_found/handler))

(def reloadable-app
  (wrap-reload #'app))

(defn port [] {:port 3000})
(defn -main []
  (run-jetty reloadable-app (port)))