# SQLPBP12 - Rating 650

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### High Price of Products
### Task

Write a query to find all `product_name` and `category` that have a price greater than 100.00 from the  **Products**  table.

Table name:  **`Products`** 

product_id	product_name	price	category
1	Laptop	999.99	Electronics
2	Desk Chair	149.99	Furniture
3	Smartphone	599.99	Electronics
4	Notebook	2.99	Stationery
5	Headphones	89.99	Electronics
6	Coffee Maker	49.99	Appliances
7	Standing Desk	249.99	Furniture
8	Tablet	399.99	Electronics
9	Mouse	19.99	Electronics
10	Water Bottle	12.99	Stationery
### Expected columns
- product_name
- category

## Solution

**Language:** SQL  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-02T16:22:49.996Z  

```sql
-- your code goes here
SELECT product_name, category FROM Products where price >100.00;
```

---

[View on CodeChef](https://www.codechef.com/problems/SQLPBP12)