(ns clobin.server
  (:require [noir.server :as server]
            [clobin.models.paste :as p]))

(server/load-views "src/clobin/views/")


(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (p/initialise)
    (server/start port {:mode mode
                        :ns 'clobin})))

