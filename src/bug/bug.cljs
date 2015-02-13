(ns bug
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async]))

; error only happens with `#js`-literals wihtin `go`-blocks
    (let [a true] (assert (first #js[a])))  ; ok
(go (let [b true] (assert (first    [b])))) ; ok
(go (let [c true] (assert (first #js[c])))) ; fail
