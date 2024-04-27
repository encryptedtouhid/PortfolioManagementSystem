## Creating schema

CREATE SCHEMA `portfolio_schema` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

## Creating table

### Customer table
CREATE TABLE `portfolio_schema`.`customer` (
`id` VARCHAR(50) NOT NULL,
`customer_name` VARCHAR(50) NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB;


### Portfolio table

CREATE TABLE `portfolio_schema`.`portfolio` (
`id` VARCHAR(45) NOT NULL,
`customer_id` VARCHAR(45) NOT NULL,
`portfolio_number` VARCHAR(45) NOT NULL,
`portfolio_value` VARCHAR(45) NOT NULL,
`current_performance` VARCHAR(20) NOT NULL,
`investment_strategy` VARCHAR(10) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `customer_id_fk`
FOREIGN KEY (customer_id)
REFERENCES `portfolio_schema`.`customer` (id));


### Instrument table

CREATE TABLE `portfolio_schema`.`instrument` (
`id` VARCHAR(45) NOT NULL,
`instrument_name` VARCHAR(45) NOT NULL,
`instrument_type` VARCHAR(10) NOT NULL,
`instrument_value` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`));

### Position table

CREATE TABLE `portfolio_schema`.`position` (
`id` VARCHAR(45) NOT NULL,
`porfolio_id` VARCHAR(45) NOT NULL,
`instrument_id` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `portfolio_position_fk`
FOREIGN KEY (porfolio_id)
REFERENCES `portfolio_schema`.`portfolio` (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `instrument_position_fk`
FOREIGN KEY (instrument_id)
REFERENCES `portfolio_schema`.`instrument` (id));

### Audit table

CREATE TABLE `portfolio_schema`.`audit` (
`id` VARCHAR(45) NOT NULL,
`transaction_ref` VARCHAR(45) NOT NULL,
`portfolio_id` VARCHAR(45) NOT NULL,
`instrument_id` VARCHAR(45) NOT NULL,
`unit` INT NOT NULL,
`trade_type` VARCHAR(4) NOT NULL,
`audit_date` DATETIME NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `audit_instrument_fk`
FOREIGN KEY (instrument_id)
REFERENCES `portfolio_schema`.`instrument` (id),
CONSTRAINT `audit_portfolio_fk`
FOREIGN KEY (portfolio_id)
REFERENCES `portfolio_schema`.`portfolio` (id));