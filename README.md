# TravelEPSI setup

Install `npm install -g http-server`

`cd front && http-server`

Don't forget to change api path in `front/scripts/app.js`

Hook assets up with: `bower install`

## hibernate.cfg.xml

Copy `hibernate.cfg.xml.sample` to `hibernate.cfg.xml` and custom it to your need:

`cd src/main/resources/META-INF && cp hibernate.cfg.xml{.sample,} && cd -`

## Database

`mysql < database.sql` in terminal.
