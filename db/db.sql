DROP TABLE IF EXISTS savepicture;
CREATE TABLE savepicture (
  id int(10) NOT NULL auto_increment,
  picture blob NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
