# Coinpurse

`coinpurse` is used to make a model like the purse that contains the coin(s).
User can try deposit and withdraw the coin(s).
- `Coin` is a valuable thing that consist of currency and value like a coin.
- `CoinUtil` is a valuable utility that help practice using Lists and Comparator
  by using sumByCurrency, SortByCurrency, and filterByCurrency.
- `ConsoleDialog` is the ui for this coinpurse. User can deposit, withdraw, 
  ask for inquiry, and quit the program.
- `Main` is used to create `Purse` and run the `ConsoleDialog`.
- `Purse` is a class that consist of `Valuable` and it's capacity like a purse.
  User can insert the `Valuable`, count the `Valuable`, get the total value, check is it full,
  and withdraw the `Valuable`.
- `PurseTest` is the tester for `Purse`. It use `org.junit.*` to test is this `Purse` work correctly.
   It's not work in lab4.
- `BankNote` is the valuable things to insert in the purse. It consist of currency, value,and
  serial number like a bank note.
- `Valuable` is the interface to implemented by the valuable things.

# Author : Chawakorn Suphepre