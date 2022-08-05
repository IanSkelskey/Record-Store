SELECT
    employee.EmployeeID, employee.Name, location.LocationName AS 'Works At'
FROM
    employee,
    location
WHERE
    employee.LocationID = location.LocationID
ORDER BY location.LocationID;