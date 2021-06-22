Feature: Booking search
  Scenario Outline: Search for a hotel
    Given Enter destination/property name
    When User does search
    Then Hotel <hotel> is on the first page
    And Check hotel rating
  Examples:
    | location | hotel                        | rating |
    | "Minsk"  | "DoubleTree by Hilton Minsk" | "9.2"  |
    | "Grodno" | "Apartment on Kirova"        | "9.7"  |
    
    