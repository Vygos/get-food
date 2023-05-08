CREATE TABLE IF NOT EXISTS USERS
(
    USER_ID         UUID         NOT NULL PRIMARY KEY,
    NAME            VARCHAR(255) NOT NULL,
    REGISTER_NUMBER VARCHAR(11)  NOT NULL,
    BIRTHDAY_DATE   DATE         NOT NULL,
    ACTIVE          BOOLEAN      NOT NULL,
    ONLINE          BOOLEAN      NOT NULL,
    CREATED_AT      timestamptz  NOT NULL,
    UPDATED_AT      timestamptz  NOT NULL
);

CREATE TABLE IF NOT EXISTS DELIVERIES
(
    DELIVERY_ID UUID NOT NULL PRIMARY KEY,
    USER_ID     UUID NOT NULL PRIMARY KEY,
    ORDER_ID    UUID NOT NULL PRIMARY KEY,


)