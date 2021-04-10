Feature: Amazon search
     
	Scenario Outline: Search book of test
		Given website loaded
		When search book for testing
		And  choose book <name>
		Then confirmed data of book <title> , <author> , <rank>
		
	Examples:
		| name 													| title 																				 | author 			| rank |
		| Guide to Software Test Design | A Practitioner's Guide to Software Test Design  | Lee Copeland | 30 |
		| Design Patterns for High-Quality Automated Tests: High-Quality | Design Patterns for High-Quality Automated Tests: High-Quality Test Attributes and Best Practices | Anton Angelov | 27 |