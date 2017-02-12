# Coinpurse

`coinpurse` is used to make a model like the purse that contains the coin(s).
User can try deposit and withdraw the coin(s).
- `Coin` is a class that consist of currency and value like a coin.
- `CoinUtil` is a coin utility that help practice using Lists and Comparator
  by using sumByCurrency, SortByCurrency, and filterByCurrency.
- `ConsoleDialog` is the ui for this coinpurse. User can deposit, withdraw, 
  ask for inquiry, and quit the program.
- `Main` is used to create `Purse` and run the `ConsoleDialog`.
- `Purse` is a class that consist of `Coin` and it's capacity like a purse.
  User can insert the `Coin`, count the `Coin`, get the total value, check is it full,
  and withdraw the `Coin`.
- `PurseTest` is the tester for `Purse`. It use `org.junit.*` to test is this `Purse` work correctly.

# Author : Chawakorn Suphepre