This is a [Giter8][g8] template for Elm with Akka-Http in Scala.

```
sbt new yannick-cw/elm-akka-http.g8
```

### running

Starting the file watcher for elm:

* `cd app/elm && npm install`
* `npm run watch`

Starting the akka-http server:

* `sbt run`

Find the server at `localhost:8080`

### developing

This project builds on elm and scala.
All frontend stuff is found in `app/elm` and all server related code is found in
`app/jvm`.

License
-------
Written in 2014-2017 by Lightbend, Inc.
To the extent possible under law, the author(s) have dedicated all copyright and related and neighboring rights to
this template to the public domain worldwide. This template is distributed without any warranty.
See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/