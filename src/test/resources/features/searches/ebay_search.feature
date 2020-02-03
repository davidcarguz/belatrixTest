#Author: David Cardenas Guzman
@searches_feature
Feature: Searches in Ebay web page. 

@shoes_search
Scenario Outline: user searches for shoes and filters results by brand and size. 
	Given  user enters to Ebay WebPage 
	When looks for shoes in searchbox 
	And filters by brand <brand> 
	And filters by size <size> 
	And sort results by price in ascendant order 
	Then validate that product are sort in ascendant order by price 
	
	Examples: 
		| brand	 | size	|
		| "PUMA" | "10" |
		
