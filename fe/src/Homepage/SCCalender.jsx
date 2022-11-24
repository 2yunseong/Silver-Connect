import Calendar from '@toast-ui/react-calendar';
import DatePicker from './DatePicker';
import useSWR from 'swr';
import '@toast-ui/calendar/dist/toastui-calendar.min.css';
import fetcher from '../util/fetcher';
import { createRef, useEffect } from 'react';

function SCCalender({ householdId, setResidentId }) {
  const calendarRef = createRef();

  const { data, error } = useSWR(
    `http://133.186.219.125:8080/api/calendar/${householdId}/month/12`,
    fetcher,
  );

  useEffect(() => {
    if (data) {
      setTimeout(() => {
        const instance = calendarRef.current.getInstance();
        instance.on('clickEvent', (eventObj) => {
          setResidentId(eventObj.event.id);
        });
      }, 0);
    }
  }, [data, calendarRef, setResidentId]);

  if (error) return <div>failed to load</div>;
  if (!data) return <div>loading...</div>;

  const initialData = data.map((resident) => {
    return {
      id: resident.id,
      calendarId: 'cal1',
      title: resident.residentName,
      start: new Date(+resident.epochTime * 1000),
      end: new Date(+(resident.epochTime + 3600) * 1000),
    };
  });

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
          events={initialData}
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
