import Select from './Select';
import './List.css';
import { useNavigate } from 'react-router-dom';

const dummyLists = [
  {
    name: '장광팔',
    address: '광주광역시 북구 호동로 73번길 71',
    age: '80',
    phone: '010-0000-0000',
    supporter: '김선희',
    supporterPhone: '010-1111-1111',
  },
  {
    name: '최득춘',
    address: '광주광역시 북구 호동로 77번길 71',
    age: '93',
    phone: '010-0000-0000',
    supporter: '김선희',
    supporterPhone: '010-1111-1111',
  },
  {
    name: '최길남',
    address: '광주광역시 북구 호동로 70번길 71',
    age: '72',
    phone: '010-0000-0000',
    supporter: '박미정',
    supporterPhone: '010-1111-1111',
  },
  {
    name: '이남희',
    address: '광주광역시 북구 문화로 71',
    age: '78',
    phone: '010-0000-0000',
    supporter: '김영희',
    supporterPhone: '010-1111-1111',
  },
];

const List = () => {
  const navigate = useNavigate();

  const onClick = () => {
    navigate('/select');
  };
  return (
    <div className='table-container flex justify-center items-center'>
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
          {dummyLists.map((household) => (
            <tr onClick={onClick} className='text-xl border-b-2'>
              <td className='py-7'>{household.name}</td>
              <td className='py-7'>{household.address}</td>
              <td className='py-7'>{household.age}</td>
              <td className='py-7'>{household.phone}</td>
              <td className='py-7'>{household.supporter}</td>
              <td className='py-7'>{household.supporterPhone}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default List;
