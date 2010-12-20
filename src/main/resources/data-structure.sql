CREATE TABLE IF NOT EXISTS application_log (
  application_log_id bigint(20) NOT NULL AUTO_INCREMENT,
  log_code char(3) NOT NULL,
  message varchar(255) NOT NULL,
  PRIMARY KEY (application_log_id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

-- --------------------------------------------------------

--
-- Table structure for table 'good_reception'
--

CREATE TABLE IF NOT EXISTS good_reception (
  good_reception_id bigint(20) NOT NULL AUTO_INCREMENT,
  administration_amount int(11) DEFAULT NULL,
  reception_notes varchar(255) DEFAULT NULL,
  official_amount int(11) DEFAULT NULL,
  reception_date date NOT NULL,
  supplier_id bigint(20) NOT NULL,
  PRIMARY KEY (good_reception_id),
  KEY FK9BBC91CD5D36A8A6 (supplier_id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Table structure for table 'item'
--

CREATE TABLE IF NOT EXISTS item (
  item_id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  item_name varchar(75) NOT NULL,
  PRIMARY KEY (item_id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table 'item_reception'
--

CREATE TABLE IF NOT EXISTS item_reception (
  item_reception_id bigint(20) NOT NULL AUTO_INCREMENT,
  amount int(11) DEFAULT NULL,
  good_reception_id bigint(20) NOT NULL,
  item_id bigint(20) NOT NULL,
  PRIMARY KEY (item_reception_id),
  KEY FKF72118A3BC4E3C73 (good_reception_id),
  KEY FKF72118A350016546 (item_id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Table structure for table 'supplier'
--

CREATE TABLE IF NOT EXISTS supplier (
  supplier_id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  supplier_name varchar(50) NOT NULL,
  PRIMARY KEY (supplier_id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `good_reception`
--
ALTER TABLE `good_reception`
  ADD CONSTRAINT FK9BBC91CD5D36A8A6 FOREIGN KEY (supplier_id) REFERENCES supplier (supplier_id);

--
-- Constraints for table `item_reception`
--
ALTER TABLE `item_reception`
  ADD CONSTRAINT FKF72118A350016546 FOREIGN KEY (item_id) REFERENCES item (item_id),
  ADD CONSTRAINT FKF72118A3BC4E3C73 FOREIGN KEY (good_reception_id) REFERENCES good_reception (good_reception_id);
