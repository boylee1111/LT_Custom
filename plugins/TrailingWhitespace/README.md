## Trailing Whitespace Plugin for Light Table

Original CodeMirror's plugin is [here](http://codemirror.net/addon/edit/trailingspace.js).

### Install

Clone this repo in your Light Table plugin directory.

### Usage

Execute `Editor: Toggle trail whitespace` command.

If you want to enable trailing whitespace as default behavior,
please change `user.behaviors` as follows.

```clojure
:editor [
  ; add following line to enable trailing whitespace
  :lt.plugins.trail-whitespace/show-trailing-whitespace
  ]
```


### License

Copyright (C) 2014 [uochan](http://twitter.com/uochan).

Distributed under the GPLv3, see LISENCE.md for the full text.
