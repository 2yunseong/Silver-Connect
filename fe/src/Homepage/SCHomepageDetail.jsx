import { useEffect } from 'react';
import fetcher from '../util/fetcher';
import useSWR from 'swr';

function SCHomepageDetail({ residentId }) {
  const { data, error } = useSWR(
    `http://133.186.219.125:8080/api/household/${residentId}`,
    fetcher,
  );
  if (error) return <div>failed to load</div>;
  if (!data) return <div>loading...</div>;

  const initalData = {
    name: data.residentName,
    age: data.residentAge,
    address: data.address,
    guardian: '김선희',
    guardianPhoneNumber: '010-1234-5678',
    risk: '안전',
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

function DetailElement(prop) {
  return (
    <div className="flex text-2xl font-semibold my-4">
      <div className="w-20">{prop.title}</div>
      <div>{prop.data}</div>
    </div>
  );
}

function DetailAlertElement(prop) {
  const types = {
    안전: '#25BF34',
    위협: '#FFEA2C',
    위험: '#ED6400',
    긴급: '#F31818',
  };
  useEffect(() => {
    document.querySelector('#warning-alert').style.backgroundColor =
      types[prop.type];
  });
  return (
    <div className="flex text-2xl font-semibold my-4">
      <div className="w-20">{prop.title}</div>
      <div className="flex">
        <div className="w-8 h-89 rounded-full mr-2" id="warning-alert" />
        <div>{prop.type}</div>
      </div>
    </div>
  );
}

export default SCHomepageDetail;
