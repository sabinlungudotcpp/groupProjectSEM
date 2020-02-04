# USE CASE: Produce a report of the population data in each Capital City

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *Researcher*, I want a report of the population data in each Capital City so that the organisation is more informed about the data of the population.

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

1. Organisation requests population information for a given Capital City.
2. Researcher captures the Capital City name to get population information for it.
3. Researcher extracts current population information of the Capital City. 
4. Researcher provides report to the organisation.

## EXTENSIONS

3. **Capital City does not exist**:
    1. Researcher informs organisation no Capital City exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
