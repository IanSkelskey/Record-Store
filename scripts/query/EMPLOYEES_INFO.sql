SELECT
    employee.EmployeeID, employee.Name, location.LocationName AS 'Works At'
FROM
    employee,
    location
WHERE
    employee.EmployeeID = location.LocationID
ORDER BY location.LocationID;