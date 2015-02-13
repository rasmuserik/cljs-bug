`src/bug/bug.cljs` has test-case that provokes the bug:

    (ns bug
      (:require-macros [cljs.core.async.macros :refer [go]])
      (:require [cljs.core.async]))
    
    ; error only happens with `#js`-literals wihtin `go`-blocks
        (let [a true] (assert (first #js[a])))  ; ok
    (go (let [b true] (assert (first    [b])))) ; ok
    (go (let [c true] (assert (first #js[c])))) ; fail

Run with `lein cljsbuild once && node build/main.js`:

    Compiling ClojureScript.
    Compiling "build/main.js" from ["src"]...
    WARNING: Use of undeclared Var bug/c at line 8 src/bug/bug.cljs
    Successfully compiled "build/main.js" in 16.813 seconds.
    
    /home/rasmuserik/repos/cljs-bug/build/main.js:5477
        throw b instanceof Object && a[6].Ta(), b;
                                                ^
    Error: Assert failed: (first #js [c])
    

See project.clj for tested version.
