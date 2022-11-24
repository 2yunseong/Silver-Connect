import Calendar from '@toast-ui/react-calendar';
import DatePicker from './DatePicker';
import useSWR from 'swr';
import '@toast-ui/calendar/dist/toastui-calendar.min.css';
import fetcher from '../util/fetcher';
import { createRef } from 'react';

function SCCalender() {
  const { data, error } = useSWR(
    'http://133.186.219.125:8080/api/calendar/1/month/12',
    fetcher,
  );
  if (error) return <div>failed to load</div>;
  if (!data) return <div>loading...</div>

  const initialEvents = data.map((resident) => {
    return {
      id: resident.id,
      calendarId: 'cal1',
      title: resident.residentName,
      start: new Date(+resident.epochTime * 1000),
      end: new Date(+(resident.epochTime + 3600) * 1000),
    };
  });

  const calendarRef = createRef();
  console.log(calendarRef.current);

  return (
    <div className="mx-8 w-3/5">
      <div className="flex justify-between items-center">
        <DatePicker />
        <img className="h-full" src="./images/alertBar.png" alt="alertBar" />
      </div>
      <div id="calender">
        <Calendar
          usageStatistics={false}
          view={'month'}
          events={initialEvents}
          disableDblClick={false}
          disableClick={false}
          isReadOnly={true}
          ref={calendarRef}
        />
      </div>
    </div>
  );
}

export default SCCalender;
