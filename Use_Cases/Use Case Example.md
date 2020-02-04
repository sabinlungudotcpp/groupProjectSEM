# USE CASE: 4 Produce a report of the population of people, people living in cities, and people not living in cities in each region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *Researcher*, I want a report of the population of people, people living in cities, and people not living in cities in each region so that the organisation is more informed about the data of the population.

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current population data.

### Success End Condition

A report is available for the Researcher to provide to the rest of the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Researcher.

### Trigger

A request for population information is sent to the Researcher.

## MAIN SUCCESS SCENARIO

1. Researcher requests population information for a given continent.
2. Researcher captures the continent to get population information for.
3. Researcher extracts current population information of each region. 
4. Researcher provides report to the organisation.

## EXTENSIONS

3. **Region does not exist**:
    1. Researcher informs organisation no region exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
