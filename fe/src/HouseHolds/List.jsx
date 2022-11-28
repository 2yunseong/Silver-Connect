import { Link } from 'react-router-dom';
import useSWR from 'swr';

import fetcher from '../util/fetcher';
import './List.css';

const List = () => {
  const types = {
    SAFE: '안전',
    WARN: '인지',
    DANGER: '위험',
    EMERGENCY: '긴급',
  };

  const { data, error } = useSWR(
    'http://133.186.219.125:8080/api/guardian/all/',
    fetcher
  );

  if (error) return <div>fail read</div>;
  if (!data) return <div>loading..</div>;

  return (
    <div className='table-container flex justify-center items-center flex-col border rounded-lg py-10 shadow-lg'>
      <h1 className='font-bold text-5xl py-10'>관리 가구 목록</h1>
      <table className='text-center'>
        <thead>
          <tr className='font-bold text-base text-slate-400'>
            <td className='px-10'>위험도</td>
            <td className='px-10'>이름</td>
            <td className='px-10'>주소</td>
            <td className='px-10'>연세</td>
            <td className='px-10'>연락처</td>
            <td className='px-10'>보호자 이름</td>
            <td className='px-10'>보호자 연락처</td>
          </tr>
        </thead>
        <tbody>
          {data.map((element) => {
            return (
              <tr className='text-xl border-b-2 px-5'>
                <td className='py-7'>
                  <div className='flex'>
                    <div
                      className={`w-7 h-89 rounded-full mr-2 ${element.household.risk}`}
                    />
                    <div>{types[element.household.risk]}</div>
                  </div>
                </td>
                <td className='py-7'>
                  <Link to={`${element.id}`}>
                    {element.household.residentName}
                  </Link>
                </td>
                <td className='py-7'>
                  <Link to={`${element.id}`}>{element.household.address}</Link>
                </td>
                <td className='py-7'>
                  <Link to={`${element.id}`}>
                    {element.household.residentAge}
                  </Link>
                </td>
                <td className='py-7'>
                  <Link to={`${element.id}`}>
                    {element.household.residentPhoneNumber}
                  </Link>
                </td>
                <td className='py-7'>
                  <Link to={`${element.id}`}>{element.name}</Link>
                </td>
                <td className='py-7'>
                  <Link to={`${element.id}`}>{element.phoneNumber}</Link>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default List;
