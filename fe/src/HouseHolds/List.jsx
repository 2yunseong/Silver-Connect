import Select from './Select';
import './List.css';
import { useNavigate } from 'react-router-dom';
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

  const onClick = () => {
    navigate('/select');
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
          {data.map((element) => (
            <tr onClick={onClick} className='text-xl border-b-2'>
              <td className='py-7'>{element.household.residentName}</td>
              <td className='py-7'>{element.household.address}</td>
              <td className='py-7'>{element.household.residentAge}</td>
              <td className='py-7'>{element.household.residentPhoneNumber}</td>
              <td className='py-7'>{element.name}</td>
              <td className='py-7'>{element.phoneNumber}</td>
            </tr>
          ))}
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
