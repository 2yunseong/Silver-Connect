import { useState } from 'react';
import './Homepage.css';
import SCCalender from './SCCalender';
import SCHomepageDetail from './SCHomepageDetail';

function Homepage() {
  const [residentId, setResidentId] = useState(1);

  return (
    <div className="flex">
      <SCCalender householdId={1} setResidentId={setResidentId} />
      <div className="mt-6 border-r-2 border-blue-300"></div>
      <SCHomepageDetail residentId={residentId} />
    </div>
  );
}

export default Homepage;
