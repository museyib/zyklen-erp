INSERT INTO COUNTRY (COUNTRY, COUNTRY_NAME)
VALUES ('AU', N'Avstriya'),
       ('AZ', N'Azərbaycan'),
       ('BR', N'Braziliya'),
       ('CH', N'Çin'),
       ('CZ', N'Çexiya'),
       ('DE', N'Almaniya'),
       ('ID', N'İndoneziya'),
       ('IN', N'Hindistan'),
       ('IR', N'İran'),
       ('IT', N'İtaliya'),
       ('KR', N'Koreya'),
       ('PL', N'Polşa'),
       ('RU', N'Rusiya'),
       ('T-A', N'Türkiyə-Az'),
       ('TR', N'Türkiyə'),
       ('UA', N'Ukrayna'),
       ('US', N'ABŞ'),
       ('JP', N'Yaponiya');
INSERT INTO PROVINCE (ID,
                      COUNTRY,
                      PROVINCE_CODE,
                      PROVINCE_NAME)
VALUES (1,
        'AZ',
        '1',
        N'Bakı');

INSERT INTO DISTRICT (COUNTRY,
                      PROVINCE_CODE,
                      DISTRICT_CODE,
                      DISTRICT_NAME)
VALUES ('AZ',
        '1',
        '1',
        N'Binəqədi');

INSERT INTO SETTLEMENT (COUNTRY,
                        PROVINCE_CODE,
                        DISTRICT_CODE,
                        SETTLEMENT_CODE,
                        SETTLEMENT_NAME)
VALUES ('AZ',
        '1',
        '1',
        '1',
        N'28 May');

INSERT INTO BMS_USER_GROUP (USER_GROUP_ID,
                            USER_GROUP_NAME)
VALUES ('ADMIN', 'Administrators'),
       ('GUEST', 'Guests'),
       ('POSWIN', 'POS Users [Wins]'),
       ('RETAIL', 'Retail Users'),
       ('SYSTEM', 'System user');


INSERT INTO BRANCH (BRANCH_CODE,
                    BRANCH_NAME,
                    SHORT_NAME,
                    COUNTRY,
                    DISTRICT_CODE,
                    PROVINCE_CODE,
                    FIRST_REC_USER,
                    FIRST_REC_DATE,
                    FIRST_HOST_NAME)
VALUES ('OFC',
        N'Mərkəz Ofis',
        N'Mərkəz',
        'AZ',
        '1',
        '1',
        'Spring Boot',
        GETDATE(),
        'Server');

-- noinspection SqlInsertValues
INSERT INTO COMPANY (CC,
                     COMPANY_NAME,
                     SHORT_NAME,
                     COUNTRY_CODE,
                     FIRST_REC_USER,
                     FIRST_REC_DATE,
                     FIRST_HOST_NAME)
VALUES ('INCI',
        N'İnci',
        N'İnci',
        'AZ',
        'Spring Boot',
        GETDATE(),
        'Server');

INSERT INTO CURRENCY (CURR_CODE, CURR_NAME, CENT_NAME, INACTIVE_FLAG)
VALUES ('AZN', 'Manat', N'Qəpik', 0)

INSERT INTO BMS_ROLE (ROLE_ID,
                      ROLE_DESC)
VALUES ('ADMIN',
        N'Administrator');

INSERT INTO PRICE_MASTER (PRICE_CODE,
                          PRICE_NAME,
                          BASE_PC,
                          FACTOR,
                          CURR_CODE,
                          ORDER_ID,
                          ROUND_LENGTH)
VALUES ('LST',
        N'Son alış qiyməti',
        'LST',
        1,
        'AZN',
        1,
        4);

INSERT INTO CSH_MASTER(CSH_CODE,
                       CSH_NAME,
                       SHORT_NAME,
                       BRANCH_CODE,
                       CURR_CODE,
                       INACTIVE_FLAG,
                       FIRST_REC_USER,
                       FIRST_REC_DATE,
                       FIRST_HOST_NAME)
VALUES ('AZN01',
        N'AZN kassası',
        N'AZN kassası',
        'OFC',
        'AZN',
        0,
        'Spring Boot',
        GETDATE(),
        'Server');

INSERT INTO WHS_MASTER (WHS_CODE,
                        WHS_NAME,
                        SHORT_NAME,
                        BRANCH_CODE,
                        PICKING_FLAG,
                        LOCATION_FLAG,
                        INACTIVE_FLAG,
                        FIRST_REC_USER,
                        FIRST_REC_DATE,
                        FIRST_HOST_NAME)
VALUES ('01',
        N'Əsas anbar',
        N'Əsas anbar',
        'OFC',
        0,
        0,
        0,
        'Spring Boot',
        GETDATE(),
        'Server');

INSERT INTO BMS_USER (USER_ID,
                      USER_NAME,
                      PASS_WORD,
                      ADMIN_FLAG,
                      USER_GROUP_ID,
                      EMAIL,
                      REMOTE_ACCESS_FLAG,
                      FIRST_REC_USER,
                      FIRST_REC_DATE,
                      TERMINAL_FLAG,
                      INACTIVE_FLAG,
                      FIRST_HOST_NAME,
                      RETAIL_FLAG)
VALUES ('ADMIN',
        'Admin',
        '123456',
        1,
        'ADMIN',
        'info@example.com',
        1,
        'Spring Boot',
        GETDATE(),
        1,
        0,
        'Server',
        1);

INSERT INTO BMS_USER_ROLE (USER_ID,
                           ROLE_ID)
VALUES ('ADMIN',
        'ADMIN');

INSERT INTO BMS_USER_WHS (USER_ID,
                          WHS_CODE)
VALUES ('ADMIN',
        '01');

INSERT INTO BMS_USER_BRANCH (USER_ID,
                             BRANCH_CODE,
                             DEFAULT_FLAG)
VALUES ('ADMIN',
        'OFC',
        1);

INSERT INTO BMS_USER_COMPANY (USER_ID,
                              CC)
VALUES ('ADMIN',
        'INCI');