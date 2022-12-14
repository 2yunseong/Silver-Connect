import { useEffect } from 'react';
import fetcher from '../util/fetcher';
import useSWR from 'swr';

function SCHomepageDetail({ residentId }) {
  if (residentId === -1) {
    return (
      <div className="w-2/5 flex items-left flex-col mt-6 ml-6">
        <div className="text-4xl font-bold my-16">정보</div>
        <DetailElement title={'이름'} data={''} />
        <DetailElement title={'주소'} data={''} />
        <DetailElement title={'연세'} data={''} />
        <div className="border-y-2 mr-6 my-4" />
        <DetailElement title={'보호자'} data={''} />
        <DetailElement title={'연락처'} data={''} />
        <div className="border-y-2 mr-6 my-4" />
        <DetailAlertElement title={'위험도'} type={'SAFE'} />
      </div>
    );
  }

  // eslint-disable-next-line react-hooks/rules-of-hooks
  const { data, error } = useSWR(
    `http://133.186.219.125:8080/api/guardian/?householdId=${residentId}`,
    fetcher,
  );
  if (error) {
    return (
      <div className="w-2/5 flex items-left flex-col mt-6 ml-6">
        failed to load
      </div>
    );
  }
  if (!data) {
    return (
      <div className="w-2/5 flex items-left flex-col mt-6 ml-6">loading...</div>
    );
  }

  const initalData = {
    name: data.household.residentName || '',
    age: data.household.residentAge || '',
    address: data.household.address || '',
    guardian: data.name || '',
    guardianPhoneNumber: data.phoneNumber || '',
    risk: data.household.risk || '',
  };

  return (
    <div className="w-2/5 flex items-left flex-col mt-6 ml-6">
      <div className="text-4xl font-bold my-16">정보</div>
      <DetailElement title={'이름'} data={initalData.name} />
      <DetailElement title={'주소'} data={initalData.address} />
      <DetailElement title={'연세'} data={initalData.age} />
      <div className="border-y-2 mr-6 my-4" />
      <DetailElement title={'보호자'} data={initalData.guardian} />
      <DetailElement title={'연락처'} data={initalData.guardianPhoneNumber} />
      <div className="border-y-2 mr-6 my-4" />
      <DetailAlertElement title={'위험도'} type={initalData.risk} />
    </div>
  );
}

function DetailElement({ title, data }) {
  return (
    <div className="flex text-2xl font-semibold my-4">
      <div className="w-20">{title}</div>
      {data !== '' ? (
        <div>{data}</div>
      ) : (
        <div role="status" class="max-w-sm animate-pulse flex items-center">
          <div class="h-4 bg-gray-200 rounded-full dark:bg-gray-300 w-48"></div>
        </div>
      )}
    </div>
  );
}

function DetailAlertElement({ type, title }) {
  const types = {
    SAFE: { color: '#25BF34', string: '안전' },
    WARN: { color: '#FFEA2C', string: '인지' },
    DANGER: { color: '#ED6400', string: '위험' },
    EMERGENCY: { color: '#F31818', string: '긴급' },
  };
  useEffect(() => {
    document.querySelector('#warning-alert').style.backgroundColor =
      types[type].color;
  });
  return (
    <div className="flex text-2xl font-semibold my-4">
      <div className="w-20">{title}</div>
      <div className="flex">
        <div className="w-8 h-89 rounded-full mr-2" id="warning-alert" />
        <div>{types[type].string}</div>
      </div>
    </div>
  );
}

export default SCHomepageDetail;
