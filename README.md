# Activity-Auditor-UI

An AngularJS/Clojure UI for [Activity Auditor] (https://github.com/VirginPulsePublic/activity-auditor) allowing quick searching of audited SQS messages.

## Usage

*Running*

```el
$> npm install && bower install
$> lein with-profile dev ring server
```

*Setup* includes editing the config.edn file in the config folder to set your database settings.  It also assumes you have a schema as followed:

```el
CREATE TABLE activity_audit
(
  id character varying NOT NULL,
  message character varying,
  "timestamp" timestamp with time zone
)
WITH (
  OIDS=FALSE
);
ALTER TABLE activity_audit
  OWNER TO your_user_here;

```

## License

Copyright © 2014 Tyler Hoersch

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
