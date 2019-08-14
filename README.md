# Strategy Pattern
 
 
 
 
Add functionality such that this bank supports Savings and Checkings accounts. For all
accounts we want to add interest, and the interest is calculated with the algorithms given
below. Use the strategy pattern.
Interest for a savings account:
If balance < 1000 then you get 1% interest
If balance > 1000 and balance < 5000 then you get 2% interest
If balance > 5000 then you get 4% interest

Interest for a checkings account:
If balance < 1000 then you get 1,5% interest
If balance > 1000 then you get 2,5% interest
* Draw the modified class diagram with the strategy pattern applied.
* Draw a sequence diagram that shows how your new design works. On the sequence
diagram you should show how the strategy pattern works. The AccountService should
have a method addInterest(), and then the interest should be calculated and added to all
accounts.
* Implement the addInterest() functionality using the strategy pattern in the given code


