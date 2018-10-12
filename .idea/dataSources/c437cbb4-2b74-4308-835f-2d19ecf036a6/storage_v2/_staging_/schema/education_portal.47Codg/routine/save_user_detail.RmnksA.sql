CREATE PROCEDURE save_user_detail(IN  in_user_id    INT(11),
                                  IN  in_first_name VARCHAR(45),
                                  IN  in_last_name  VARCHAR(45),
                                  IN  in_e_mail     VARCHAR(45),
                                  IN  in_birth_date DATETIME,
                                  IN  in_counrty    VARCHAR(45),
                                  IN  in_city       VARCHAR(45),
                                  OUT out_result    tinyint(1))
  BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
      SET out_result = FALSE;
      START TRANSACTION;
      UPDATE user_detail
      SET first_name = in_first_name,
          last_name  = in_last_name,
          e_mail     = in_e_mail,
          birth_date = in_birth_date,
          country    = in_counrty,
          city       = in_city
      WHERE user_id = in_user_id;
      COMMIT;
      SET out_result = true;
    END;
  END;
