(ns clobin.templates
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]
        [hiccup.util :only [escape-html]]
        [hiccup.element :only [link-to]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "clobin"]
               (include-css "/css/bootstrap.css")
               (include-css "/css/styles.css")
               (include-css "/css/shCore.css")
               (include-css "/css/shThemeDefault.css")
               (include-js "/js/shCore.js")
               (include-js "/js/shBrushCpp.js") 
               (include-js "/js/shBrushBash.js") 
               (include-js "/js/shBrushFortran.js") 
               ]
              [:body
               [:div.container
                [:header
                 [:h1 (link-to "/" "Clobin")]
                 [:h2 "a simple clojure pastebin"]]
                content
                [:footer
                 (link-to "/about" "About")
                 " | Created by "
                 (link-to "http://www.davidbeckingsale.com" "David Beckingsale")]
                [:script "SyntaxHighlighter.all()"]]]))

(defpartial index [& content]
            (layout
              [:form {:method "post" :action "" :class "form-stacked"}
               [:fieldset.text
                 [:label {:for "text"} "Enter some text to paste:"]
                 [:textarea {:name "text"}
                  "text"]]
               [:fieldset.select
                [:label {:for "language" } "Select paste language"]
                 [:select {:name "language" :id "language"}
                  [:option "cpp"]
                  [:option "fortran"]
                  [:option "shell"]]]
               [:button {:type "submit" :class "btn btn-primary btn-large"} "Paste!"]]
              content))

(defpartial paste [{:keys [language paste]}]
            (layout
              [:pre {:class (str "brush: " language)} paste]))
