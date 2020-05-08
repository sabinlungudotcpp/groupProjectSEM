
--People living in cities - Continent
SELECT cityPopulation.Continent, Continent_Population, City_Population, ((City_Population/Continent_Population) * 100) AS '(City_Population %)', (Continent_Population - City_Population) AS Rural_Population, (((Continent_Population - City_Population)/Continent_Population) * 100) AS '(Rural_Population %)'
FROM
(SELECT SUM(city.Population) AS City_Population, country.Continent FROM city
INNER JOIN country ON (city.CountryCode = country.code)
GROUP BY country.Continent) AS cityPopulation
INNER JOIN
(SELECT SUM(country.Population) AS Continent_Population, country.Continent FROM country
GROUP BY country.Continent) AS continentPopulation
ON (cityPopulation.Continent = continentPopulation.Continent);

--People living in cities - Region
SELECT cityPopulation.Region, Region_Population, City_Population, ((City_Population/Region_Population) * 100) AS '%', (Region_Population - City_Population) AS Rural_Population, (((Region_Population - City_Population)/Region_Population) * 100) AS '%'
FROM
(SELECT SUM(city.Population) AS City_Population, country.Region FROM city
INNER JOIN country ON (city.CountryCode = country.code)
GROUP BY country.Region) AS cityPopulation
INNER JOIN
(SELECT SUM(country.Population) AS Region_Population, country.Region FROM country
GROUP BY country.Region) AS RegionPopulation
ON (cityPopulation.Region = RegionPopulation.Region);

--People living in cities - Country
SELECT cityPopulation.Country_Name, Country_Population, City_Population, ((City_Population/Country_Population) * 100) AS '%', (Country_Population - City_Population) AS Rural_Population, (((Country_Population - City_Population)/Country_Population) * 100) AS '%'
FROM
(SELECT SUM(city.Population) AS City_Population, country.Name AS Country_Name FROM city
INNER JOIN country ON (city.CountryCode = country.code)
GROUP BY country.Name) AS cityPopulation
INNER JOIN
(SELECT SUM(country.Population) AS Country_Population, country.Name AS Country_Name FROM country
GROUP BY country.Name) AS countryPopulation
ON (cityPopulation.Country_Name = countryPopulation.Country_Name);

--World population
SELECT SUM(country.Population) AS World_Population FROM country;

SELECT country.Continent, SUM(country.Population) AS Population FROM country
WHERE country.Continent = 'Asia';

SELECT country.Region, SUM(country.Population) AS Population FROM country -- Selects the country region, sums the population where the region is middle east.
WHERE country.Region = 'Middle East';

SELECT country.Name, country.Population AS Population FROM country
WHERE country.Name = 'China';

SELECT city.District, SUM(city.Population) AS Population FROM city
WHERE city.District = 'New York';

SELECT city.Name, city.Population AS Population FROM city
WHERE city.Name = 'New York';

SELECT SUM(country.Population) AS World_Population INTO @world_population FROM country;

SELECT Language, SUM(ROUND((Population * Percentage/100), 0)) AS No_Speakers, ((SUM(ROUND((Population * Percentage/100), 0)))/@world_population)*100 AS 'Percentage of People in World Who Speak Language'
FROM countrylanguage
INNER JOIN country ON (country.Code = countrylanguage.CountryCode)
WHERE Language = 'Chinese' OR Language = 'English' OR Language = 'Hindi' OR Language = 'Spanish' OR Language = 'Arabic'
GROUP BY Language
ORDER BY No_Speakers DESC
;
