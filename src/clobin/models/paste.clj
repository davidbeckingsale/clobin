(ns clobin.models.paste
  (:require [taoensso.carmine :as r]
            [hiccup.util :as hu]))

(def pool (r/make-conn-pool :max-active 8))
(def spec-server1 (r/make-conn-spec :host     "127.0.0.1"
                                    :port     6379
                                    :timeout  4000))

(defmacro carmine
  "Acts like (partial with-conn pool spec-server1)."
  [& body] `(r/with-conn pool spec-server1 ~@body))

(defn initialise 
  "Initialise the first pid to 0 in our redis store."
  []
  (carmine (r/set "pid" "0")))

(defn add!
  "Add a new paste."
  [{:keys [paste]}] 
  (let [pid (carmine (r/get "pid"))]
    (carmine 
      (r/set pid (hu/escape-html paste))
      (r/incr "pid"))
    pid))

(defn get!
  "Get a stored paste."
  [{:keys [pid]}]
  (carmine (r/get pid)))

(get! {:pid "0"})
