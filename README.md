# Java , Swing, MySQL tutorial project 

### Self implemented over and above the tutorial
* better error handling and user experience by showing dialogs for edge cases
  * acccount exists
  * card number already exists
  * withdraw below balance 0.0
  * upgrading depreceated functions to current ones 
* abstracted user tables
  * Unique table for each user
  * unique transaction table for each card number ( account number)
  * signup details / enrollment bifercated into three seperate table with primary key and foreign keys
* logic for handling previous accounts and already generated account number
* account creation based on type of account and transactions based on certains rules
