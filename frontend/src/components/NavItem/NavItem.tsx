import { Link } from "react-router-dom";

function NavItem({ to, label }: { to: string; label: string }) {
  return (
    <li>
      <Link 
        to={to} 
        className="text-white text-base hover:text-black transition-colors duration-300">
        {label}
      </Link>
    </li>
  );
}

export default NavItem;
