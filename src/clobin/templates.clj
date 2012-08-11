(ns clobin.templates
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "clobin"]
               (include-css "/css/bootstrap.css")
               (include-css "/css/styles.css")]
              [:body
               [:div.container
                [:header
                 [:h1 "Clobin"]
                 [:h2 "a simple clojure pastebin"]]
                content]]))

(defpartial index [& content]
            (layout
              [:form {:method "post" :action "" :class "form-stacked"}
               [:fieldset.text
                 [:label {:for "text"} "Enter some text to paste:"]
                 [:textarea {:name "text"}
                  "text"]]
               [:button {:type "submit" :class "btn btn-primary btn-large"} "Paste!"]]
              content))
