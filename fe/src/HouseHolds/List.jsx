import Select from './Select';
import './List.css';
import { useNavigate, Link } from 'react-router-dom';
import { useState } from 'react';
import Add from './Add';
import useSWR from 'swr';
import fetcher from '../util/fetcher';

const List = () => {
  const [isAddClick, setIsAddClick] = useState(false);
  const navigate = useNavigate();

  const { data, error } = useSWR(
    'http://133.186.219.125:8080/api/guardian/all/',
    fetcher
  );

  const onClick = (e) => {
    console.log(e);
  };

  const onAdd = () => {
    setIsAddClick(() => !isAddClick);
  };

  if (error) return <div>fail read</div>;
  if (!data) return <div>loading..</div>;

  return (
    <div className='table-container flex justify-center items-center flex-col'>
      <table className='text-center'>
        <thead>
          <tr className='font-bold text-base text-slate-400'>
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
              <tr className='text-xl border-b-2'>
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
      <button
        className='m-8 px-8 py-2 bg-blue-600 rounded-lg text-white'
        onClick={onAdd}
      >
        추가
      </button>
      {isAddClick && (
        <Add isAddClick={isAddClick} setIsAddClick={setIsAddClick} />
      )}
    </div>
  );
};

export default List;
