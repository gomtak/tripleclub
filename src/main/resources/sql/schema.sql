CREATE TABLE `user`
(
    `user_id`   varchar(255) NOT NULL,
    `user_name` varchar(100) NOT null,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `place`
(
    `place_id`   varchar(255) NOT NULL,
    `place_name` varchar(100) NOT NULL,
    PRIMARY KEY (`place_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `review`
(
    `review_id` varchar(255) NOT NULL,
    `content`   varchar(255) DEFAULT NULL,
    `is_bonus`  bit(1)       DEFAULT NULL,
    `place_id`  varchar(255) DEFAULT NULL,
    `user_id`   varchar(255) DEFAULT null,
    PRIMARY KEY (`review_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
    FOREIGN KEY (`place_id`) REFERENCES `place` (`place_id`)
--     INDEX       `idx` (`place_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `attached_photo`
(
    `attached_photo_id` varchar(255) NOT NULL,
    `review_id`         varchar(255) NOT NULL,
    PRIMARY KEY (`attached_photo_id`),
    FOREIGN KEY (`review_id`) REFERENCES `review` (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `mileage`
(
    `mileage_id` varchar(255) NOT NULL,
    `user_id`    varchar(100) NOT NULL,
    `review_id`  varchar(255) NOT NULL,
    `point`      int,
    PRIMARY KEY (`mileage_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
    FOREIGN KEY (`review_id`) REFERENCES `review` (`review_id`),
    INDEX        `idx` (`user_id`,`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;