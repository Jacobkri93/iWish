CREATE TABLE `useradmin`.`wishlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `item_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `FK_item_id_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `FK_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `useradmin`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_item_id`
    FOREIGN KEY (`item_id`)
    REFERENCES `useradmin`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);