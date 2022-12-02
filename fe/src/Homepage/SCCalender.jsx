import Calendar from '@toast-ui/react-calendar';
import DatePicker from './DatePicker';
import useSWR from 'swr';
import '@toast-ui/calendar/dist/toastui-calendar.min.css';
import { createRef, useEffect } from 'react';

const mulFetcher = (...urls) => {
  const f = url => fetch(url).then(r => r.json())
  return Promise.all(urls.map(url => f(url)))
}

function SCCalender({ userId, setResidentId }) {
  const calendarRef = createRef();
  const { data, error } = useSWR(
    [`http://133.186.219.125:8080/api/calendar/${userId}/month/12`,
    `http://133.186.219.125:8080/api/calendar/${userId}/month/11`],
    mulFetcher,
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

  if (error) return <div className="mx-8 w-3/5">failed to load</div>;
  if (!data) return <div className="mx-8 w-3/5">loading...</div>;

  const flatData = data.flat();
  console.log(flatData);;
  const initialData = flatData.map((resident) => {
    return {
      id: resident.guardian.household.id,
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
